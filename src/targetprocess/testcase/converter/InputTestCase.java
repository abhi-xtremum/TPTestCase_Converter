package targetprocess.testcase.converter;


public class InputTestCase 
{
	int testcase_id;
	String module;
	String description;
	String steps;
	String expected_result;
	String comment;
	
	
	public int getTestcase_id() {
		return testcase_id;
	}
	
	public void setTestcase_id(int testcaseId) {
		testcase_id = testcaseId;
	}
	
	public String getModule() {
		return module;
	}
	
	public void setModule(String module) {
		this.module = module;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getExpected_result() {
		return expected_result;
	}
	
	public void setExpected_result(String expectedResult) {
		expected_result = expectedResult;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}