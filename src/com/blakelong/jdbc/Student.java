package com.blakelong.jdbc;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
// @Table is optional as long as class and table name are the same
@Table(name="student")
public class Student {
	
}
