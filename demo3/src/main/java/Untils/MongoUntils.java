package Untils;



import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import Model.Category;

@Component
public class MongoUntils{
DBCollection myCollection;
public MongoUntils(MongoDbFactory factory)
{
	DB db = factory.getDb();
	myCollection=db.getCollection("mycollection");
	
}

public void InsertCategory(Category cate)
{
	BasicDBObject object= new BasicDBObject();
	object.put("code", cate.getCode());
	object.put("name", cate.getName());
	object.put("description", cate.getDescription());
	myCollection.insert(object);
	
}
}
