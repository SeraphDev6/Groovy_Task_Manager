class TaskList{
  List tasks = []

  void AddTask(){
    String name = System.console().readLine "What is the name of the task?"
    String desc = System.console().readLine "Give a short decription of the task?"
    Integer days = 0
    String input = ""
    while (days <= 0){
      try{
        input = System.console().readLine "How many days do you have to complete this task?"
        days = Integer.parseInt(input)
        if(days <= 0){
          throw Exception("$input is not a positive integer")
        }
      }
      catch(Exception ex){
        println "$input is not a positive integer. Please try again"
      }
    }
    tasks.add([name, desc, new Date().plus(days), false] as Task)
    println "Successfully add task $name"
    SaveToCsv("Tasks.csv")
  }

  void CompleteTask(){
    String input = System.console().readLine "Which task have you completed?"
    for(Task task in tasks){
      if (!task.completed && task.name.toLowerCase() == input.toLowerCase()){
        task.completed = true
        println "Successfully completed task $task.name!"
        return
      }
    }
    println "Could not find task with name $input. Try again."
  }

  @Override
  String toString(){
    tasks.join("\n\n")
  }

  static TaskList FromCsv(String path){
    File f = new File(path)
    List lines = f.readLines().tail()*.split(',')

  }

  void SaveToCsv(path){
    File f = new File(path)
    List f.text = this.tasks*.ToCsv().join(System.lineSeparator())
  }
}
