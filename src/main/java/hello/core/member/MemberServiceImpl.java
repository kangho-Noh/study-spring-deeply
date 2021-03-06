package hello.core.member;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    //MemberServiceImpl가 MemoryMemberRepository를 직접 요구하고 있다. -> 객체가 인터페이스뿐만 아니라 구현체를 둘 다 의존
    // -> OCP, DIP를 위반하는 것. 역할에만 의존해야함
    private final MemberRepository memberRepository;

    //@Autowired => ac.getBean(MemberRepository.class)와 같은 역할
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
