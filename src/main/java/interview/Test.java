package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		
	List<Student> inputList=new ArrayList<>();
	inputList.add(new Student(1,"Kishor","Pune",200));
	inputList.add(new Student(2,"Nilesh","Pune",400));
	inputList.add(new Student(3,"Ganesh","Mumbai",400));
	
	// map key as city & value as list of students belonging to city	
            Map<String, List<Student>> resultMap = inputList.stream().collect(Collectors.groupingBy(Student::getCity));
            resultMap.forEach((k,v)->
            {System.out.println("key:"+k+" :: value :"+v);});
	
	}

}
