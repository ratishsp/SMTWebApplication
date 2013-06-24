/**
 * 
 */
package com.saba.converter;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;
import com.saba.model.Aij;

/**
 * @author rpuduppully
 *
 */
public class AijReadConverter implements Converter<DBObject, Aij> {

	@Override
	public Aij convert(DBObject source) {
//		System.out.println(source.toString());
		DBObject ij = (DBObject) source.get("ij");
		int i=0;
//		DBObject rowIj = null;

		while(((DBObject)(ij.get(String.valueOf(i))))!= null){
			i++;
		}
		int [][] rIj = new int[i][2];

		int k=0;
		while(((DBObject)(ij.get(String.valueOf(k))))!= null){
			rIj[k] = fetchRowEntries((DBObject)(ij.get(String.valueOf(k))));
			k++;
		}
		
		return new Aij((String)source.get("r"), rIj);
	}

	private int[] fetchRowEntries(DBObject dbObject) {
		int [] rIj = new int[2];
		rIj[0] = (Integer)dbObject.get("0");
		rIj[1] = (Integer)dbObject.get("1");
		return rIj;
	}
}
