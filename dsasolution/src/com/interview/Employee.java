package com.interview;

public class Employee {

	private String employeeId;
	private String employeeName;

	private Employee(Builder eBuilder) {
		this.employeeId = eBuilder.employeeId;
		this.employeeName = eBuilder.employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

	public static class Builder {

		private String employeeId;
		private String employeeName;

		public Builder employeeId(String employeeId) {
			this.employeeId = employeeId;
			return this;
		}

		public Builder employeeName(String employeeName) {
			this.employeeName = employeeName;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}
}
