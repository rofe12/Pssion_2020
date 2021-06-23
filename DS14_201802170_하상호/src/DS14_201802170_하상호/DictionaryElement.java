package DS14_201802170_«œªÛ»£;

public class DictionaryElement <Key,Obj> 
{

	private Key _key;
	private Obj _object;
	
	 public DictionaryElement () {
		 this.setKey(null);
		 this.setObject(null);
	 }
	 public DictionaryElement (Key givenKey, Obj givenObject) {
		 this.setKey(givenKey);
		 this.setObject(givenObject);
	 }
	 public Key key () {
		 return this._key;
	 }
	 public void setKey (Key newKey) {
		 this._key = newKey;
	 }
	 public Obj object () {
		 return this._object;
	 }
	 public void setObject (Obj newObject) {
		 this._object = newObject;
	 }
}
