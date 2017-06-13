package com.r3pi.booksexplorer;

import com.r3pi.booksexplorer.model.BooksListJSONModel;
import com.r3pi.booksexplorer.model.IBooksListCallback;
import com.r3pi.booksexplorer.model.IModelRepository;
import com.r3pi.booksexplorer.ui.BooksList.BookListItemViewModel;
import com.r3pi.booksexplorer.ui.BooksList.BookListItemViewModelFactory;
import com.r3pi.booksexplorer.ui.BooksList.BooksListAdapter;
import com.r3pi.booksexplorer.ui.BooksList.BooksListViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookListUnitTest {

    private static final String VOLUME_ID = "12345";
    private static final String BOOK_DESCRIPTION = "book description text";
    private static final String BOOK_TITLE = "some title";
    private static final String BOOK_AUTHOR = "author of the book";
    private static final String BOOK_YEAR = "1234";
    private static final String BOOK_DETAILS_URL = "http://book.details.url";
    private static final String BOOK_COVER_URL = "http://book.cover.url";

    private static final String SEARCH_QUERY_BOOK = "book to search";
    private static final int START_IDX = 0;
    private static final int NUM_RESULTS = 3;
    private IModelRepository mockModelRepo;
    private BookListItemViewModelFactory mockListItemVMFactory;
    private BooksListAdapter mockListAdapter;

    @Before
    public void setup() {
        BookListItemViewModel mockBookItemVM = new BookListItemViewModel(BOOK_COVER_URL, BOOK_TITLE, BOOK_AUTHOR, BOOK_YEAR, BOOK_DETAILS_URL, VOLUME_ID);

        mockListItemVMFactory = Mockito.mock(BookListItemViewModelFactory.class);
        Mockito.when(mockListItemVMFactory.getBookListItemViewModel(Mockito.any(BooksListJSONModel.Item.class))).thenReturn(mockBookItemVM);

        final List<BooksListJSONModel.Item> mockBooksListJSON = new ArrayList<>();
        for (int i=0; i < NUM_RESULTS; i++) {
            mockBooksListJSON.add(Mockito.mock(BooksListJSONModel.Item.class));
        }

        mockModelRepo = Mockito.mock(IModelRepository.class);
        Mockito.when(mockModelRepo.getBooksList(Mockito.eq(SEARCH_QUERY_BOOK), Mockito.eq(START_IDX), Mockito.any(IBooksListCallback.class))).thenAnswer(
                new Answer<Object>() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        ((IBooksListCallback) invocation.getArguments()[2]).onResult(mockBooksListJSON, START_IDX);
                        return null;
                    }
                });

        mockListAdapter = Mockito.mock(BooksListAdapter.class);
    }

    @Test
    public void testSearchBook() throws Exception {
        BooksListViewModel booksListViewModel = new BooksListViewModel(mockModelRepo, mockListItemVMFactory);
        booksListViewModel.setAdapter(mockListAdapter);

        booksListViewModel.searchBooks(SEARCH_QUERY_BOOK);

        assertEquals(NUM_RESULTS, booksListViewModel.getListContents().size());

        assertEquals(BOOK_TITLE, booksListViewModel.getListContents().get(0).title.get());
    }

}
