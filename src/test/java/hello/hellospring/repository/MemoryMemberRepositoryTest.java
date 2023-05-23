package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // 메소드가 끝날때마다 동작함
    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        // given
        Member member = new Member();
        member.setName("memberA");
        // when
        memoryMemberRepository.save(member);
        Member result = memoryMemberRepository.findById(member.getId()).get();

        // then
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("memberA");

        Member member2 = new Member();
        member2.setName("memberB");
        // when
        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);
        Member result = memoryMemberRepository.findByName("memberB").get();
        
        // then
        assertThat(result).isEqualTo(member2);

    }
    @Test
    public void findAll() throws Exception {
        Member member1 = new Member();
        member1.setName("memberA");

        Member member2 = new Member();
        member2.setName("memberB");
        // when
        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();
        // then
        assertThat(result.size()).isEqualTo(2);
    }

}