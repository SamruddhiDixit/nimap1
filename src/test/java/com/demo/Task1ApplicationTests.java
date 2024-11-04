package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Task1ApplicationTests {

	@Test
	void contextLoads() {

		@Entity // This annotation marks the class as a JPA entity
		@Table(name = "categories") // Specifies the table name in the database
		public class Category {

		    // Define the fields and annotate them
		    
		    @Id // Specifies the primary key of the entity
		    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the value for ID
		    private Long id;

		    @Column(name = "name", nullable = false) // Maps this field to a database column
		    private String name;

		    @Column(name = "description") // Maps this field to a database column
		    private String description;

		    // Default constructor (required by JPA)
		    public Category() {
		    }

		    // Parameterized constructor (optional)
		    public Category(String name, String description) {
		        this.name = name;
		        this.description = description;
		    }

		    // Getters and Setters for each field

		    public Long getId() {
		        return id;
		    }

		    public void setId(Long id) {
		        this.id = id;
		    }

		    public String getName() {
		        return name;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    public String getDescription() {
		        return description;
		    }

		    public void setDescription(String description) {
		        this.description = description;
		    }
		}

	}

}
