package com.psl.business;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.psl.data.api.TodoService;
import com.psl.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		
		List<String> expected = new ArrayList<String>();
		expected.add("Learn Spring MVC");
		expected.add("Learn Spring");
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Abhi");
		assertEquals(expected, todos);
	}
}