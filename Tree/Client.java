package Tree;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str="10 true 20 true 40 false false true 50 false false true 30 false true 60 false false";
String str="10 false true 30 true 60 false false false ";
//String str="10 true 20 true 40 false false true 50 false false true 30 false true 60 false false";
		Construct c=new Construct(str);
//	c.root=null;
	c.display();
	c.leftOrder();
	
	}

}
