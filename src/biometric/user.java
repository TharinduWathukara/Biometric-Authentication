/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometric;

/**
 *
 * @author tharindu
 */
public class user {

    protected String name;
    protected float phaseTime;

    public user(String name, float phaseTime) {
        this.name = name;
        this.phaseTime = phaseTime;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPhaseTime() {
        return phaseTime;
    }

    public void setPhaseTime(int phaseTime) {
        this.phaseTime = phaseTime;
    }



}
