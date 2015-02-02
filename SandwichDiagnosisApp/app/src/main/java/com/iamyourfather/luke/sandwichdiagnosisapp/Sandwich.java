import java.util.*;
/*
 * Represents a sandwich, and contains relevant information, such as a unique
 * sandwich id (also indicates sandwich qualities), the sandwich name, and a
 * URL of a recipe for the sandwich
 * 
 * @author Kyle Ferris, Rose Walton
 */
public class Sandwich {
	//id number of sandwich
	private String id;
	//name of the sandwich
	private String name;
	//website of where the sandwich recipe can be found
	private String recipeURL;
	
	/*
	 * Constructs a sandwich object and assigns the specified sandwich ID, name,
	 * and recipe location.
	 * 
	 * @String id -unique number to identify the sandwich
	 * @String name -name of the sandwich
	 * @String recipeURL -url of a recipe for the sandwich
	 */
	public Sandwich (String id, String name, String recipeURL) {
		this.setId(id);
		this.setName(name);
		this.setRecipeURL(recipeURL);
	}
	
	/*
	 * Returns the unique sandwich ID value.
	 * @return String id
	 */
	public String getId() {
		return id;
	}
	/*
	 * Sets the unique sandwich ID value.
	 * @param String id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * Returns the sandwich name.
	 * @return String name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Sets the sandwich name.
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Returns the URL location of the sandwich recipe.
	 * @return String recipeURL
	 */
	public String getRecipeURL() {
		return recipeURL;
	}

	/*
	 * Sets the URL location of the sandwich recipe.
	 * @param String recipeURL
	 */
	public void setRecipeURL(String recipeURL) {
		this.recipeURL = recipeURL;
	}
	
	@Override
	public String toString() {
		return name + "\n" + recipeURL;
	}
	
}
