/**
 * 
 */
package com.saba.process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.saba.model.Cu;
import com.saba.model.Cuv;
import com.saba.model.Cuvw;
import com.saba.model.U;
import com.saba.model.Uv;
import com.saba.model.Uvw;
import com.saba.translation.CuRepository;
import com.saba.translation.CuvRepository;
import com.saba.translation.CuvwRepository;
//import javax.persistence.Query;

/**
 * @author rpuduppully
 *
 */
public class LanguageModel {

	private static final String TRAINING_FILE = "D:/project/study/nlp/h3/corpus.en";
//	private static final String TRAINING_FILE = "/home/arya/nlp/h3/dev.en";
	private static final int START = 1;
	private static final int STOP = 2;
	private static final String STAR = "@#!@#!@#!";
	private static final String STOP_SYMBOL ="^&%$%$^$&^&";
	private static final String SPACE = " "; 
//	private Map<Uvw,Integer> cuvw = new HashMap<Uvw,Integer>();
//	private Map<Uv,Integer> cuv = new HashMap<Uv,Integer>();
//	private Map<U,Integer> cu = new HashMap<U,Integer>();
//	private Map<Uvw,Float> qwgivenuv = new HashMap<Uvw,Float>();
//	private Map<Uv,Float> qwgivenv = new HashMap<Uv,Float>();
//	private Map<U,Float> qw = new HashMap<U,Float>();
	private static final int total =152153;
	@Autowired
	private CuvwRepository cuvwRepository;
	@Autowired
	private CuvRepository cuvRepository;
	@Autowired
	private CuRepository cuRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	/**
	 * @param args
	 */
	public void process() {
		readTrainingData();
	}
	
	public static void main(String[] args) {
		LanguageModel languageModel = new LanguageModel();
//		languageModel.countTotal();
	}

/*	public void countTotal() {
		try{
			BufferedReader br1 = new BufferedReader(new FileReader(TRAINING_FILE));
			String inputLine = null;
			while((inputLine = br1.readLine())!=null){
				String[] inputLineArgs = inputLine.split(SPACE);
				total += inputLineArgs.length;
			}
			br1.close();
			
			System.out.println("total "+total);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
//	public Map<U, Integer> getCu() {
//		return cu;
//	}
//	
//	public Map<Uvw, Integer> getCuvw() {
//		return cuvw;
//	}
//	
//	public Map<Uv, Integer> getCuv() {
//		return cuv;
//	}
	
	public void readTrainingData() {
		try {
//			f.put
			BufferedReader br1 = new BufferedReader(new FileReader(TRAINING_FILE));
			String inputLine = null;
			while((inputLine = br1.readLine())!=null){
				String[] args = inputLine.split(SPACE);
				
//				Uv uv = new Uv(STAR, args[0]);
//				incrementValueCuv(cuv, uv);
//				Uvw uvw = new Uvw(STAR, STAR, args[0]);
//				incrementValueCuvw(cuvw, uvw);
//				uvw = new Uvw(STAR, args[1], args[2]);
//				incrementValueCuvw(cuvw, uvw);
//				total += args.length;
				String [] tokens = new String[args.length +3];
				tokens[0] = STAR;
				tokens[1] = STAR;
				tokens[tokens.length -1] = STOP_SYMBOL;
				System.arraycopy(args, 0, tokens, 2, args.length);
				for (int i = 2; i < tokens.length; i++) {
					String w = tokens[i];
					String u = tokens[i-2];
					String v = tokens[i-1];
					Uvw uvw = new Uvw(u, v, w);
					incrementValueCuvw(uvw);
					
					Uv uv = new Uv(v, w);
					incrementValueCuv(uv);
					
					U uobj = new U(w);
					incrementValueCu(uobj);
				}
			}
			br1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void incrementValueCu(U key) {
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
		Cu cuInstance = find(key);
//		Cu cuInstance = cuRepository.find
		if(cuInstance != null){
			cuInstance.setC(cuInstance.getC()+1);
			cuRepository.save(cuInstance);
		}else{
			cuRepository.save(new Cu(key, 1));
		}
	}

	private Cu find(U key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("u.u").is(key.getU()));
		Cu cuInstance = mongoTemplate.findOne(query, Cu.class);
		return cuInstance;
	}
	private void incrementValueCuvw( Uvw key) {
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
//		Cuvw cuvwInstance =cuvwRepository.findOne(key);
		Cuvw cuvwInstance = find(key);

		if(cuvwInstance != null){
			cuvwInstance.setC(cuvwInstance.getC()+1);
			cuvwRepository.save(cuvwInstance);
		}else{
			cuvwRepository.save(new Cuvw(key,1));
		}
	}

	private Cuvw find(Uvw key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("uvw.u").is(key.getU()).and("uvw.v").is(key.getV()).and("uvw.w").is(key.getW()));
		Cuvw cuvwInstance = mongoTemplate.findOne(query, Cuvw.class);
		return cuvwInstance;
	}
	private void incrementValueCuv(Uv key){
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
		
		Cuv cuvInstance = find(key);

		if(cuvInstance != null){
			cuvInstance.setC(cuvInstance.getC()+1);
			cuvRepository.save(cuvInstance);
		}else{
			cuvRepository.save(new Cuv(key,1));
		}
	}

	private Cuv find(Uv key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("uv.u").is(key.getU()).and("uv.v").is(key.getV()));
		Cuv cuvInstance = mongoTemplate.findOne(query, Cuv.class);
		return cuvInstance;
	}

	public float findq(String u, String v, String w){
		if(u.length()==0 && v.length()==0){
			u = STAR;
			v = STAR;
		}
		if(u.length() == 0){
			u  = STAR;
		}
		Uvw uvw = new Uvw(u, v, w);
		Uv uv = new Uv(v, w);
		U uObj = new U(w);
//		Integer countUvw = cuvw.get(uvw);
//		Integer countUv = cuv.get(uv);
//		Integer countU = cu.get(uObj);
		Cuvw cuvw = find(uvw);
		Integer countUvw = cuvw == null? 0: cuvw.getC();
		Cuv cuv = find(uv);
		Integer countUv = cuv == null? 0:cuv.getC();
		Cu countUObj = find(uObj);
		Integer countU = countUObj == null ? 0: countUObj.getC();
		
		float q = 0;
		if(countUv != null && countUvw != null  && countUv !=0){
			q+= (float)countUvw/countUv;
		}
		
		if(countU != null && countUv != null && countU !=0){
			q+= (float)countUv/countU;
		}
		
		q+= (float)countU/total;
		
		return q/3;
	}
}
