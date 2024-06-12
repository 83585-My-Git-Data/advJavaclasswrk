package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	
		private User user;
		private int candidateId;
		private int count;

		
		public VoteBean() {}
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		} 
		
		public int getCandidateId() {
			return candidateId;
		}
		public void setCandidateId(int candidateId) {
			this.candidateId = candidateId;
		}

		public void registerVote() {
			
			try(CandidateDao cd = new CandidateDaoImpl();
					UserDao u = new UserDaoImpl()){
				if(user.getStatus() == 0) {
					count = cd.incrementVote(candidateId);
					u.updateStatus(user.getId(), true);
				}else {
					count = 5;
				}
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
}
