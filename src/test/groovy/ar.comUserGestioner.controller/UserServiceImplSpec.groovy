package ar.com.UserGestioner.controller

import ar.com.UserGestioner.builder.UserResponseBuilder
import ar.com.UserGestioner.model.entity.User
import ar.com.UserGestioner.model.request.UserRequest
import ar.com.UserGestioner.model.response.UserResponse
import ar.com.UserGestioner.repository.UserRepository
import ar.com.UserGestioner.service.impl.UserServiceImpl
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import spock.lang.Specification
class UserServiceImplSpec extends Specification {
  def userServiceImpl = new UserServiceImpl();

  def userResponse = Mock(UserResponse);
  def userRepository =Mock(UserRepository);
  def user= Mock(User);
  @Value('${user.gestioner.token}')
  private String token;
  def setup() {
    user.setId(1234);
  }
  
  def "test createUser method"() {
    given:
    def userRequest = new UserRequest(name: "John Doe", email: "johndoe@example.com")

      userServiceImpl.buildUserResponse(_) >> this.userResponse;
      userRepository.existsUserByEmail(_)>>false;
      userRepository.getByMail(_)>>user;
      userServiceImpl.userRepository=userRepository;
    when:
    def result = userServiceImpl.singUp(userRequest);

    then:
    assert result.getId() == userResponse.getId();
  }
}
