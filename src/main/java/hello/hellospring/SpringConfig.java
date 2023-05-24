package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// DI 방법 2. 스프링 빈 등록
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    private DataSource dataSource;
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new jpaMemberRepository(em);
//        return new
//    }


}
