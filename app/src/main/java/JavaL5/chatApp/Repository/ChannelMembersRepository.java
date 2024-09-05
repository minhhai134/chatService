package JavaL5.chatApp.Repository;

import JavaL5.chatApp.Model.ChannelMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelMembersRepository extends JpaRepository<ChannelMembers,String> {
}
