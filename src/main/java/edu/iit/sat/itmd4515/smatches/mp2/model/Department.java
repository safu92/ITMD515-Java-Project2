
package edu.iit.sat.itmd4515.smatches.mp2.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
    
    @NotNull
    @Size(max = 4)
    private String deptId;

    @NotNull
        @Size(max = 40)
    private String deptName;

    public Department(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Department() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getDeptId() {
        return deptId;
    }

    /**
     * Set the value of deptId
     *
     * @param deptId new value of deptId
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

}
