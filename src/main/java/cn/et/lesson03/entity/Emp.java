package cn.et.lesson03.entity;

public class Emp {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.id
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.ename
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    private String ename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.sal
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    private Long sal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.deptid
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    private Integer deptid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.id
     *
     * @return the value of emp.id
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.id
     *
     * @param id the value for emp.id
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.ename
     *
     * @return the value of emp.ename
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public String getEname() {
        return ename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.ename
     *
     * @param ename the value for emp.ename
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.sal
     *
     * @return the value of emp.sal
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public Long getSal() {
        return sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.sal
     *
     * @param sal the value for emp.sal
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public void setSal(Long sal) {
        this.sal = sal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.deptid
     *
     * @return the value of emp.deptid
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.deptid
     *
     * @param deptid the value for emp.deptid
     *
     * @mbg.generated Wed Dec 13 10:05:34 CST 2017
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}