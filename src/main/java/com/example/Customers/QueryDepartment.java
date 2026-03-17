package com.example.Customers;

 class QueryDepartment implements CustomerCare {
	
	private String department = "Query Department";
    private String customerName;
	private String issue;
	private String refId;
	
    @Override
	public String getDepartment() {
	    return department;
	}
	    
	@Override    
	public void getService() {
	    System.out.println("\nWelcome " + customerName + "!");
	    System.out.println("You have reached the " + department + ".");
	}

	@Override
	public void setCustomerName(String name) {
		customerName = name;
		
	}

	@Override
	public void setProblem(String problem) {
		issue = problem;
		
	}

	@Override
	public void getProblem() {
	    refId = "REF-" + (int)(Math.random() * 10000);

	    System.out.println("\nDear " + customerName + ",");
	    System.out.println("Your issue has been registered with " + department + ".");
	    System.out.println("Issue: " + issue);
	    System.out.println("Reference ID: " + refId);
	}


}
