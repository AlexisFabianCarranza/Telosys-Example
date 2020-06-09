// File generated by Telosys Tools Generator ( version 3.1.2 ) - Date 2020-06-09 ( Time 12:14:13 )

// Modules imports
import { NotificationService } from './../../../services/notification.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MdDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

// Components imports
import { DeleteDialogComponent } from './../../../delete-dialog/delete-dialog.component';

// Models and services imports
import { Jobs } from './../jobs.model';
import { JobsService } from './../services/jobs.service';
import * as _ from 'underscore';

@Component({
  selector: 'app-jobs-form',
  templateUrl: './jobs-form.component.html',
  styleUrls: ['./jobs-form.component.css']
})
export class JobsFormComponent implements OnInit {

  // HTTP status code
  readonly NOT_FOUND_ERROR = 404;
  readonly CONFLICT_ERROR = 409;
  readonly INTERNAL_SERVER_ERROR = 500;

  private title = 'Jobs Form';
  private jobs: Jobs;
  private form: FormGroup;
  private ids;

  constructor(
    private _jobsService: JobsService,
    private _route: ActivatedRoute,
    private _router: Router,
    private _formBuilder: FormBuilder,
    private _notificationService: NotificationService,
    public dialog: MdDialog) { }

  ngOnInit() {
    this.getIdFromRouteParams();
    this.initForm();
  }

  getIdFromRouteParams = () => {
    this._route.params.subscribe(p => {
        this.ids = _.values(p);
    });
  }

  initForm = () => {
    this.form = this._formBuilder.group(this.getNewForm());
    if (!_.isEmpty(this.ids)) {
      this.load();
    }
  }

  getNewForm = (jobs?: Jobs) => {
    return {
      id: [
          (jobs ? jobs.id : ''),
          Validators.required
      ],
      name: [
        (jobs ? jobs.name : ''),
        Validators.required
      ],
      image: [
        (jobs ? jobs.image : '')
      ]
    };
  }


  load = () => {
    this._jobsService.getSingle(this.ids).subscribe(
      (jobs: Jobs) => {
        this.jobs = {
          id: jobs.id,
          name: jobs.name,
          image: jobs.image
		};
        this.form = this._formBuilder.group(this.getNewForm(this.jobs));
      },
      error => {
        if (error.status === this.NOT_FOUND_ERROR) {
          this._notificationService.error(error.statusText, 'Entity not found in database');
        } else if (error.status === this.INTERNAL_SERVER_ERROR) {
          this._notificationService.error(error.statusText, error.json());
        } else {
          this._notificationService.error('Error', 'An error occured when trying to reach the server');
        }
      });
  }

  save = () => {
	// If we didn't get a jobs, we are adding a jobs
    if (!this.jobs) {
      this.add();
    } else { // If we didn't get a jobs, we are adding a jobs
      this.update();
    }
  }

  add = () => {
    this._jobsService.add(this.form.value).subscribe(
      result => {
        this._notificationService.success('Success', 'Jobs added successfuly');
        this._router.navigate(['./jobs-form', this.form.value.id]);
      },
      error => {1
        if (error.status === this.CONFLICT_ERROR) {
          this._notificationService.error(error.statusText, 'Id already used in database');
        } else if (error.status === this.INTERNAL_SERVER_ERROR) {
          this._notificationService.error(error.statusText, error.json());
        } else {
          this._notificationService.error('Error', 'An error occured when trying to reach the server');
        }
      });
  }

  update = () => {
    this._jobsService.update(<Jobs>this.form.getRawValue(), this.ids).subscribe(
      result => this._notificationService.success('Success', 'Jobs edited successfuly'),
      error => {
        if (error.status === this.NOT_FOUND_ERROR) {
          this._notificationService.error(error.statusText, 'Entity not found in database');
        } else if (error.status === this.INTERNAL_SERVER_ERROR) {
          this._notificationService.error(error.statusText, error.json());
        } else {
          this._notificationService.error('Error', 'An error occured when trying to reach the server');
        }
      });
  }

  deleteConfirmation = () => {
    if (this.jobs.id) {
      const dialogRef = this.dialog.open(DeleteDialogComponent, {
        data: `jobs: ${this.jobs.id}`
      });
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          this.deleteBadge(this.jobs.id);
        }
      });
    }
  }

  deleteBadge = (id): void => {
    // Call delete service
    this._jobsService.delete(id).subscribe(
      result => {
        this._router.navigate(['./jobs-list']);

        this._notificationService.success(
          'Deleted',
          `The jobs entry with the id(s)='${id}' was deleted successfuly`);
      },
      error => {
        if (error.status === this.NOT_FOUND_ERROR) {
          this._notificationService.error(error.statusText, 'Entity not found in database');
        } else if (error.status === this.INTERNAL_SERVER_ERROR) {
          this._notificationService.error(error.statusText, error.json());
        } else {
          this._notificationService.error('Error', 'An error occured when trying to reach the server');
        }
      });
  }
}
