public class Test{
    public static void main(String[] args){
        Person[] people = new Person[3];
        people[0] = new Student(123456789,
                                "Paul Leister",
                                "972 4th Street, Allentown",
                                "610-331-7177",
                                "pleister@gmail.com",
                                "CSE");
        people[1] = new Employee(334422110,
                                 "Beth Down",
                                 "234 Main Street, Philadelphia",
                                 "484-222-4433",
                                 "bdown@gmail.com",
                                 "System Administrator",
                                 75000.0);
        people[2] = new Faculty(222222222,
                                "Mark Jones",
                                "21 Orchid Street, Bethlehem",
                                "610-333-2211",
                                "mjones@gmail.com",
                                "Faculty",
                                100000.0,
                                "Associate Professor");
        System.out.println("Original List");
        printArray(people);

        sortArray(people, true); // sort the list by name
        System.out.println("List sorted by name");
        printArray(people);

        sortArray(people, false); //sort the list by id
        System.out.println("List sorted by id");
        printArray(people);
    }
    public static void printArray(Person[] list){
        for(Person p: list){
            System.out.println(p);
        }
    }

    public static void sortArray(Person[] list, boolean type){
    		for(int i=0; i<list.length; i++){
      		int minIndex = i;
      		for(int j=i+1; j<list.length; j++)  { 
                if(type){ // sort by name
                    if(list[j].getName().compareTo(list[minIndex].getName()) < 0)
                 		minIndex = j;
                } 
                else{ // sort by id
          		    if(list[j].getID() < list[minIndex].getID())
                 		minIndex = j;
                }
            }
      	    Person temp = list[i];
      		list[i] = list[minIndex];
      		list[minIndex] = temp;
    	}
    }

}