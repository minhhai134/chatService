package JavaL5.chatApp.Controller;


import JavaL5.chatApp.Model.Channel;
import JavaL5.chatApp.Service.ChannelService;
import JavaL5.chatApp.dto.channel.CreateChannelRequest;
import JavaL5.chatApp.dto.channel.CreateChannelResponse;
import JavaL5.chatApp.dto.channel.GetChannelResponse;
import JavaL5.chatApp.exception.ChannelExistedException;
import JavaL5.chatApp.exception.ChannelNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/channels")
public class ChannelController {


    @Autowired
    private ChannelService channelService;

    @PostMapping("/create")
    public ResponseEntity<CreateChannelResponse> createChannel(@Valid @RequestBody CreateChannelRequest request){

        try {
            Channel channel = channelService.createChannel(request);

            return ResponseEntity.ok(CreateChannelResponse.builder().channel(channel).build()) ;
        }
        catch(ChannelExistedException e){
            return ResponseEntity.notFound().build();
        }



    }

    @GetMapping("{id}")
    public ResponseEntity<GetChannelResponse>  getChannelById(@PathVariable String id){

        try{
            Channel channel = channelService.getChannelById(id);
            return ResponseEntity.ok(GetChannelResponse.builder().channel(channel).build());
        }
        catch  (ChannelNotFoundException e){
            return ResponseEntity.notFound().build();
        }



    }

//    @GetMapping("{clientChannelId}/by-reference-id")
//    public GetChannelResponse getChannelByReferenceId(@PathVariable String clientChannelId){
//
//    }
}
