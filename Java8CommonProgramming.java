package Java8CommonProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8CommonProgramming {

	public static void main(String[] args) {
		
		List<Student> studentList = Stream.of(
				new Student(1, "Bhanu", 24, "Male", "ECE", "Nellore", 60, Arrays.asList("+9182926971", "+9182926981")),
				new Student(2,"Ram", 25, "Male", "CSE", "Chennai", 70, Arrays.asList("+9182926973", "+9182926988"))).collect(Collectors.toList());
		
		
		List<Student> students =
				studentList.stream().filter(student -> student.getRant() > 60 && student.getRant() < 80).collect(Collectors.toList());
				//System.out.println(students);
				
				List<String> name = Arrays.asList("Bhanu", "jana", null, "praneeth", null,"reddy");
				List<String> result = name.stream().filter(e -> e!=null)
							.collect(Collectors.toList());
				//System.out.println(result);
				
				
			//1	Stream.ofNullable
				
				
				List<String> results = name.stream().flatMap(Stream::ofNullable)
								.collect(Collectors.toList());
				//System.out.println(results);
				
				
		    //2	Stream.iterate
				
				
				Stream.iterate(1, n->n+2)
				.limit(2)
				.forEach(System.out::println);
				
				
		    //3   Stream.CollectingAndThen
				
				
				Long collect = studentList.stream().mapToDouble(Student::getRant)
									.boxed()
									.collect(Collectors.collectingAndThen(
											Collectors.averagingDouble(Double::doubleValue), Math::round));
				
				//System.out.println(collect);
				
				
		 //4    Stream.takeWhile() and Stream.dropWhile()
				
				
				List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
				
//				values.stream().takeWhile(n-> n < 5)
//				.forEach(System.out::println);
//				
//				values.stream().dropWhile(n-> n < 5)
//				.forEach(System.out::println);
				
				
				List<Integer> storevalues = values.stream()
															.dropWhile(n-> n <= 5)
															.takeWhile(n -> n < 8)
															.collect(Collectors.toList());
						//System.out.println(storevalues);
						
						
						
			//5   Stream.teeing
						
						
						
					Map<String, Integer> collectteeing = values.stream()
							.collect(Collectors.teeing(
									Collectors.maxBy(Integer::compareTo), 
									Collectors.minBy(Integer::compareTo), 
									(e1,e2)-> Map.of("Max",e1.get(),"Min",e2.get())));
						
						System.out.println(collectteeing);
						
						
						
		   //6    Stream.Concat()
						
						
						
						Stream<Integer> stream1 = Stream.of(1,2,3);
						Stream<Integer> stream2 = Stream.of(4,5,6);
						
						//Stream.concat(stream1, stream2).forEach(System.out::println);
						
						Stream<Integer> concatstream = Stream.concat(stream1, stream2);
						
						int sum = concatstream.mapToInt(Integer::intValue).sum();
						
						//System.out.println(sum);
						
						
						
			//7		Stream.partitioningBy
						
						
						
						Map<Boolean, List<Integer>> part = values.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

				       // System.out.println("odd number" + part.get(Boolean.FALSE));
				      //  System.out.println("even number" + part.get(Boolean.TRUE));
				        
				        List<Integer> evennumber = values.stream().filter(n-> n % 2 == 0).collect(Collectors.toList());
				        
				      //  System.out.println("print the Even numbers in the list:" + evennumber);
				        
				       
				        
		    // 8	IntStream for range
				        
				        
				        
				      List<Integer> intstream =  IntStream.range(1, 20).boxed().collect(Collectors.toList());
				   //   System.out.println(intstream);
				      
				      List<Integer> intstream2 =  IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
				   //   System.out.println(intstream2);
			
				      
		    //Collections.nCopies	      
			
				     
				     List<String> copies = Collections.nCopies(5, "Bhanu");
				    // System.out.println(copies);
				     
				     
			//Collections.frequency	     
				     
				     
				    List<Integer> count = Arrays.asList(1,2,3,4,5,1,6,7,6,4,3,1);
				    List<String> name2 = Arrays.asList("Bhanu", "jana","Bhanu", null, "praneeth", null,"reddy");
				    
				    int countnumber = Collections.frequency(count, 6);
				    
				    System.out.println(countnumber);
				    
				   Map<String, Integer> countMap = name2.stream().collect(Collectors.toMap(
				    									number->number,
				    									number -> Collections.frequency(name2, number),
				    									(existingvalue,newvalue)->existingvalue));
				   
				   System.out.println(countMap);
				   
				   
				   
		  //collections.disjoint()

				
				   List<Integer> list1 = new ArrayList<>();
				Collections.addAll(list1, 1,3,4,5);
				
				List<Integer> list2 = new ArrayList<>();
				Collections.addAll(list2, 6,7,8,9);
			//	System.out.println();
				   boolean collectlist = Collections.disjoint(list1, list2);
				   if(collectlist) {
					   //System.out.println("No common elements in the list: " + collectlist);
				   } else {
					   System.out.println("Common elements in the list Status: " + collectlist);
				   }
				   
				   
	   	// Collections.singleton
				   System.out.println();
				 Set<String> myCollection =  Collections.singleton("Bhanuprakash");
				 
				 try {
					 myCollection.add("Karanam");
				} catch (UnsupportedOperationException e) {
					//System.out.println("set is immutable, is can't be modified");
				}
				 
				 
		//Collections.rotate
				 List<Integer> list = new ArrayList<>();
				 for(int i =1; i<=10; i++) {
					 list.add(i);
				 }
				 //System.out.println("Original list:"+list);
				 
				 
				Collections.rotate(list, -2);
				//System.out.println(list);
				
				Collections.rotate(list, list.size());
				//System.out.println(list);
				
				
				
		// 1. java program to count the  occurarence of each character in a string
				
				String input = "bhanuprakash";
				//String[] resu = input.split("");
				//System.out.println(Arrays.toString(resu));
				List<String>  coun = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
						.entrySet().stream().filter(x-> x.getValue() > 1)
						.map(Map.Entry::getKey)
						.collect(Collectors.toList());
						
						
				//System.out.println(coun);
				
				
		// 2. java program to find all duplicate elements from a given string
				
				
				List<String> duplicateelements = Arrays.stream(input.split(""))
				
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(X-> X.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
				
				//System.out.println(duplicateelements);
				
				   
				
				
				String namess = "Bhanuprakash";
				
				
				String counting = Arrays.stream(namess.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
						.entrySet().stream().filter(X -> X.getValue() > 1)
						.findFirst().get().getKey();
						
				
				//System.out.println(counting);
				
				
				
				
				int[] numbers = {1,2,55,33,4,5,6,7,8,9};
				
				Integer highest = Arrays.stream(numbers).boxed().sorted().skip(1).findFirst().get();
				//System.out.println(highest);
				
				
				
				List<String> duplicate = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
				
				//System.out.println(duplicate);
				
			Integer highest1 = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
			//System.out.println(highest1);
				
				
	}
}
