package com.metacoding.refsocket.chat;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;

    // 리포지토리 인터페이스에 JpaRepository extends 받고 있어서
    // save든 findAll이든 리포지토리에 쿼리문 작성하지 않아도 알아서 불러다줌

    @Transactional
    public void save(String msg) {
        Chat chat =  Chat.builder().msg(msg).build();
        chatRepository.save(chat);
    }

    public List<Chat> findAll() {
        // id 기준으로 내림차순(desc) 정렬
        Sort desc = Sort.by(Sort.Direction.DESC, "id");
        return chatRepository.findAll(desc);
    }
}
