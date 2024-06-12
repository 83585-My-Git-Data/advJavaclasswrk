package com.sunbeam.Beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> list;

	public CandidateListBean() {}
	
	
	
	public List<Candidate> getList() {
		return list;
	}



	public void setList(List<Candidate> list) {
		this.list = list;
	}



	public void getCandidateList() {
		try(CandidateDao candidate = new CandidateDaoImpl()){
			list = candidate.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
