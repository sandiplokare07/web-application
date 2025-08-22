package in.sal.springboot.web_application.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService 
{
	private static List<Todo> todos=new ArrayList<>();
	
	static
	{
		todos.add(new Todo(1,"sandiplokare","learn java",
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"sandiplokare","learn String-Boot",
				LocalDate.now().plusYears(3),false));
		todos.add(new Todo(3,"sandiplokare","learn AWS",
				LocalDate.now().plusYears(2),false));
	}
	public List<Todo> findByUsername(String username)
	{
		return todos;
	}
}
