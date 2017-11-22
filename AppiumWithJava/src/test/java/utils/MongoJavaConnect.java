package utils;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoJavaConnect {

	/**
	 * In Mongo: 
	 * 		Collection	=> Tables
	 * 		Documents	=> Row and columns
	 * ---------------------------------------
	 * Global
	 */
	public MongoClient mongoClient = null;
	
	
	/**
	 * @desc Connecting to provided url eg.: "mongodb://localhost:27017"
	 * @return MongoClient Object
	 * @throws UnknownHostException
	 * @throws Exception
	 */
	public MongoClient connect(String type, String url) throws UnknownHostException, Exception{
		if( type.toLowerCase().equals("local") ){
			//Establish Local connection
			mongoClient = new MongoClient();
		}else{
			//Establish Remote Connection
			mongoClient = new MongoClient(new MongoClientURI(url));
		}
		// Returning the MongoDB client Object.
		return mongoClient;
	}
	
	/**
	 * ================================================
	 * CREATION
	 */
	
	public MongoClient insertRow(MongoClient mongoClientObj, String databaseName, String collectionName, String data) throws Exception{
		DBObject person = new BasicDBObject("_id", "jo")
					                .append("name", "Jo Bloggs")
					                .append("address", new BasicDBObject("street", "123 Fake St")
					                                             .append("city", "Faketon")
					                                             .append("state", "MA")
					                                             .append("zip", 12345))
					                .append("state", "last");
		( this.getCollection(mongoClientObj, databaseName, collectionName) ).insert(person);
		return mongoClientObj;
	}
	
	public MongoClient createDatabase(MongoClient mongoClientObj, String databaseName) throws Exception{
		DB database = mongoClientObj.getDB(databaseName);
		return mongoClientObj;
	}
	
	
	/**
	 * ===================================================
	 * Retrieval
	 */
	public DBCollection getCollection(MongoClient mongoClientObj, String databaseName, String collectionName) throws Exception{
		DB database = mongoClientObj.getDB(databaseName);
		DBCollection collection = database.getCollection(collectionName);
		return collection;
	}
	
	public DBCursor getRecordBySingleKeyValue(MongoClient mongoClientObj, String databaseName, String collectionName, String key, String value) throws Exception{
		DBObject query = new BasicDBObject(key, value);
		DBCursor cursor = ( this.getCollection(mongoClientObj, databaseName, collectionName) ).find(query);
		//This will return a document. Need further extraction.
		return cursor;
	}
	
	/**
	 * ===================================================
	 * Closing
	 */
	/**
	 * @desc Shutting down the current established connection, for provided MongoClient object.
	 * @param connObject
	 * @return boolean
	 */
	public boolean shutdown(MongoClient connObject){
		connObject.close();
		return true;
	} 
}
