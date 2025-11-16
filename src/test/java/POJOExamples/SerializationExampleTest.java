package POJOExamples;

import org.testng.annotations.Test;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationExampleTest {

	
	@Test
	public void serializationTest() throws JsonProcessingException {
		
		PojoExampleTest pe=new PojoExampleTest();
		pe.setName("SimpliLearn");
		pe.setJob("Trainings");
		
		//Serialization
		//Convert Java object into json data
		
		ObjectMapper om=new ObjectMapper();
		
		String jsondata=om.writerWithDefaultPrettyPrinter().writeValueAsString(pe);
		
		System.out.println(jsondata);
		
	}
	
	@Test
	public void deSerializationTest() throws JsonProcessingException {

		PojoExampleTest pe1=new PojoExampleTest();
		pe1.setName("SimpliLearn");
		pe1.setJob("Trainings");
		
		//Convert Java object into json data - Serialization
		ObjectMapper om=new ObjectMapper();
		String jsondata=om.writerWithDefaultPrettyPrinter().writeValueAsString(pe1);
		
		System.out.println("Java Object to JSON");
		System.out.println(jsondata);
		System.out.println("*****************************");
		//Convert Json data to Java object - Deserialization
		PojoExampleTest pe2=om.readValue(jsondata, PojoExampleTest.class);
		System.out.println("JSON String to Java Object");
		System.out.println("Name is "+pe2.getName());
		System.out.println("Job is "+pe2.getJob());
		
	}
	
}
