package model;
// Generated Aug 22, 2017 4:01:46 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Station generated by hbm2java
 */
@Entity
@Table(name="station"
    ,catalog="sms"
)
public class Station  implements java.io.Serializable {


     private int id;
     private String city;
     private String state;
     private Double latN;
     private Double longW;

    public Station() {
    }

	
    public Station(int id) {
        this.id = id;
    }
    public Station(int id, String city, String state, Double latN, Double longW) {
       this.id = id;
       this.city = city;
       this.state = state;
       this.latN = latN;
       this.longW = longW;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="CITY", length=20)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="STATE", length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="LAT_N", precision=22, scale=0)
    public Double getLatN() {
        return this.latN;
    }
    
    public void setLatN(Double latN) {
        this.latN = latN;
    }

    
    @Column(name="LONG_W", precision=22, scale=0)
    public Double getLongW() {
        return this.longW;
    }
    
    public void setLongW(Double longW) {
        this.longW = longW;
    }




}


