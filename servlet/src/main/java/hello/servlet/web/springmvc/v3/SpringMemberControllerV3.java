package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping("/new-form") //이렇게 하면 HTTP 메서드 뭐가 오든 얘가 호출됨
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form") //위의 내용이 너무 길어서 새로운 Annotation 만듬
    public String newForm(){
        return "new-form"; //문자열로 반환해도 View 이름으로 알고 알아서 처리해줌
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) { //request, response 말고 이렇게 받아올 수 있음

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) { //필요한 parameter만 받아올 수 있음
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}