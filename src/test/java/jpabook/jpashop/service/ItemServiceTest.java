package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 아이템_등록() throws Exception {

        //Given
        Album album = new Album();
        album.addStock(200);
        album.setName("앨범입니다");

        //When
        Long saveId = itemService.saveItem(album);

        //Then
        Album getItem = (Album) itemRepository.findOne(saveId);
        assertEquals(getItem, itemRepository.findOne(saveId));
    }

}