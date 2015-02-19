/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.model;

/**
 *
 * @author ALLAH
 */
public class Department {
    
    private int deptId;

    private String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" + "deptId=" + deptId + ", deptName=" + deptName + '}';
    }

    /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * Get the value of deptId
     *
     * @return the value of deptId
     */
    public int getDeptId() {
        return deptId;
    }

    /**
     * Set the value of deptId
     *
     * @param deptId new value of deptId
     */
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

}
