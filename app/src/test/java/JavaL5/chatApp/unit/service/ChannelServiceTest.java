package JavaL5.chatApp.unit.service;


import JavaL5.chatApp.dto.channel.GetChannelResponse;
import JavaL5.chatApp.model.Channel;
import JavaL5.chatApp.repository.ChannelRepository;
import JavaL5.chatApp.service.ChannelService;
import JavaL5.chatApp.service.ChannelServiceImp;
import JavaL5.chatApp.service.UserService;
import JavaL5.chatApp.service.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ChannelServiceTest {
    @Mock
    private ChannelRepository channelRepository;

    private ChannelService channelService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        channelService =  new ChannelServiceImp(channelRepository);

    }

    @Test
    public void testWithCaptor(){
        //given
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        final String channelId = "myid";
        when(this.channelRepository.findById(anyString()))
                .thenReturn(Optional.of(Channel.builder().appId("myid").build()));
        /*
        Loi ban dau do import sai thu vien cho when()
         */

        //when
        Channel channel = channelService.getChannelById(channelId);
        //then
        verify(channelRepository).findById(argumentCaptor.capture());
        verify(channelRepository, times(1)).findById("myid");

        assertThat(argumentCaptor.getValue()).isEqualTo("myid");

    }

}
