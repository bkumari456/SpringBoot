package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@Column(name="eid")
	@GeneratedValue(generator="empgen")
	@GenericGenerator(name="empgen",strategy="increment")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	@Column(name="email")
	private String empMail;
	@Column(name="egen")
	private String empGen;
	@Column(name="addr")
	private String empAddr;

	@ElementCollection
	@CollectionTable(
			name="emplangstab", //child table
		joinColumns=@JoinColumn(name="eidFk") //key column
	)
	@Column(name="langs") //element column
	@OrderColumn(name="pos") //index column
	private List<String> empLangs;
	
	@Column(name="idType")
	private String empIdType;
	@Column(name="idnum")
	private String empIdNum;
	
	//----const & methods-------
	//alt+shift+S,O(De-select-all>OK)
	public Employee() {
		super();
	}

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Employee(Integer empId, String empName, String empMail, String empGen, String empAddr, List<String> empLangs,
			String empIdType, String empIdNum) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empMail = empMail;
		this.empGen = empGen;
		this.empAddr = empAddr;
		this.empLangs = empLangs;
		this.empIdType = empIdType;
		this.empIdNum = empIdNum;
	}

	//alt+shift+S,R (selectAll>OK)
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public String getEmpGen() {
		return empGen;
	}

	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public List<String> getEmpLangs() {
		return empLangs;
	}

	public void setEmpLangs(List<String> empLangs) {
		this.empLangs = empLangs;
	}

	public String getEmpIdType() {
		return empIdType;
	}

	public void setEmpIdType(String empIdType) {
		this.empIdType = empIdType;
	}

	public String getEmpIdNum() {
		return empIdNum;
	}

	public void setEmpIdNum(String empIdNum) {
		this.empIdNum = empIdNum;
	}

	//alt+shift+S,S(OK)
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empMail=" + empMail + ", empGen=" + empGen
				+ ", empAddr=" + empAddr + ", empLangs=" + empLangs + ", empIdType=" + empIdType + ", empIdNum="
				+ empIdNum + "]";
	}
	
}
