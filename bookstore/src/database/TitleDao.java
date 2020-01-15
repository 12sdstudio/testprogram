package database;

import java.util.List;

import bean.Title;

public interface TitleDao {
	public List getTitles();
	public int add(Title title);
	public int update(Title title);
	public int delete(String id);
	public Title findByIsbn(String isbn);
}
