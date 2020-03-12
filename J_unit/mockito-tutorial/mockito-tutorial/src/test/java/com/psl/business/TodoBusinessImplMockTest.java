package com.psl.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.psl.data.api.TodoService;
import com.psl.data.stub.TodoServiceStub;

public class TodoBusinessImplMockTest {

	@Test
	public void usingAMock() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring Mvc","Learn Spring",
							"Learn to Dance");
		when(todoServiceMock.retrieveTodos("Abhi")).thenReturn(todos);
		List<String> expected = new ArrayList<String>();
		expected.add("Learn Spring Mvc");
		expected.add("Learn Spring");
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Abhi");
		System.out.println(filteredTodos);
		System.out.println(expected);
		assertEquals(expected, filteredTodos);
	}
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveTodos("Abhi")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Abhi");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {

		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Abhi")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Abhi");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		

	}
}