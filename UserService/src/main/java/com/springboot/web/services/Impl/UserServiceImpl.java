package com.springboot.web.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.web.entities.Hotel;
import com.springboot.web.entities.Rating;
import com.springboot.web.entities.User;
import com.springboot.web.repositories.UserRepository;
import com.springboot.web.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository uRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public User saveUser(User user) {
		String id=UUID.randomUUID().toString();
		user.setUserId(id);
		// TODO Auto-generated method stub
		return this.uRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.uRepo.findAll();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
//	return this.uRepo.findById(id); //to avoid optional type , u can create custom method findById that return User type like we did in SpringRestJPA
User user=this.uRepo.findByuserId(id);
//below query is to get all rating of user with given id
//RestTemplate is HTTP client , and it is used for communication between 2 services
//Rating [] rating=	this.restTemplate.getForObject("http://localhost:8083/ratings/users/"+ user.getUserId(), Rating[].class);
//now removing host and port and using service name directly
Rating [] rating=	this.restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+ user.getUserId(), Rating[].class);
List<Rating> ratings=List.of(rating);
//below query is to  find that each rating belong to which hotel
for(Rating r : ratings)
{
	//Hotel hotel=this.restTemplate.getForObject("http://localhost:8082/hotels/"+ r.getHotelId(), Hotel.class);
	Hotel hotel=this.restTemplate.getForObject("http://HOTELSERVICE/hotels/"+ r.getHotelId(), Hotel.class);
	r.setHotel(hotel);
}
user.setRatings(ratings);
return user;
	}

	@Override
	public User updateUserById(String id, User user) {
		// TODO Auto-generated method stub
		return this.uRepo.save(user);
	}

}
