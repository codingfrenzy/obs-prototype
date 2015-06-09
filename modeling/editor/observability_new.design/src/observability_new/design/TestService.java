package observability_new.design;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class TestService {
	
	public TestService(){
		
	}
	
	public String getName(EObject obj){
		
		return "Machine";
	}
	
	public List getList(EObject obj){
		ArrayList<String> arr = new ArrayList<>();
		arr.add("hi");
		arr.add("hello");
		return arr;
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println();
//		
//	}

}
