/*
 * Created on 2020-06-09 ( Date ISO 2020-06-09 - Time 12:08:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.1.2
 */

package org.demo.persistence.impl.jpa.record;

import java.io.Serializable;


import javax.persistence.*;

/**
 * Persistent class for "Jobs" entity stored in table "Jobs" <br>
 * This class is a "record entity" without JPA links  <br>
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="Jobs", catalog="agser" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="JobsJpaRecord.countAll",  query="SELECT COUNT(x) FROM JobsJpaRecord x" ),
  @NamedQuery ( name="JobsJpaRecord.countById", query="SELECT COUNT(x) FROM JobsJpaRecord x WHERE x.id = ?1 " )
} )
public class JobsJpaRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="id", nullable=false)
    private Integer    id           ; 

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", nullable=false, length=100)
    private String     name         ; 

    @Column(name="image", length=100)
    private String     image        ; 


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public JobsJpaRecord() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : image ( VARCHAR ) 
    public void setImage( String image ) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(image);
        return sb.toString(); 
    } 

}
