import org.ansj.app.keyword.*;
import org.ansj.domain.Result;
import org.ansj.domain.Term;

import org.ansj.splitWord.analysis.*;


import java.util.*;

public class Test {
	public static void main(String[] args){

/*		try{
			Class.forName("org.ansj.splitWord.analysis.ToAnalysis");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}*/
		String str = "12345678";
		str = str.replaceAll("0", "-2-");
		System.out.println(str);
		
/*		Result re = ToAnalysis.parse("司马懿");
		List<Term> terms = re.getTerms();
		for(int i=0;i<terms.size();i++){
			System.out.print(terms.get(i).getName()+" ");
			System.out.println(terms.get(i).getNatureStr());
		}
		String sql = "select IDlist from index_list where keyword like '%%%s%%'";
		System.out.println(String.format(sql, "司马懿"));*/
		
/*		KeyWordComputer kw = new KeyWordComputer(5);
		String str = "";
		Scanner sc = new Scanner(System.in);
		while(!str.equals("q")){

			str = sc.nextLine();
			List<Keyword> result = kw.computeArticleTfidf(str);
			System.out.println(result);
		}*/
		

	}
}
