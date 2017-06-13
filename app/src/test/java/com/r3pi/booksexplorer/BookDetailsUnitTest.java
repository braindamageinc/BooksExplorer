package com.r3pi.booksexplorer;

import com.r3pi.booksexplorer.model.BookDetailsJSONModel;
import com.r3pi.booksexplorer.model.IBookDetailsCallback;
import com.r3pi.booksexplorer.model.IModelRepository;
import com.r3pi.booksexplorer.ui.BookDetails.BookDetailsViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookDetailsUnitTest {

    private static final String VOLUME_ID = "12345";
    private static final String BOOK_DESCRIPTION = "book description text";
    private static final String BOOK_TITLE = "some title";
    private static final String BOOK_AUTHOR = "author of the book";
    private static final String BOOK_YEAR = "1234";
    private static final String BOOK_COVER_URL = "http://book.cover.url";

    private IModelRepository mockModelRepo;

    @Before
    public void setup() {
        final BookDetailsJSONModel mockJSONModel = Mockito.mock(BookDetailsJSONModel.class);
        BookDetailsJSONModel.VolumeInfo mockJSONVolumeInfo = Mockito.mock(BookDetailsJSONModel.VolumeInfo.class);
        Mockito.when(mockJSONModel.getVolumeInfo()).thenReturn(mockJSONVolumeInfo);
        Mockito.when(mockJSONVolumeInfo.getDescription()).thenReturn(BOOK_DESCRIPTION);

        mockModelRepo = Mockito.mock(IModelRepository.class);
        Mockito.when(mockModelRepo.getBookDetails(Mockito.eq(VOLUME_ID), Mockito.any(IBookDetailsCallback.class))).thenAnswer(
                new Answer<Object>() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        ((IBookDetailsCallback) invocation.getArguments()[1]).onResult(mockJSONModel);
                        return null;
                    }
                });
    }

    @Test
    public void testCreateBookDetailsViewModel() throws Exception {
        BookDetailsViewModel bookDetailsViewModel = new BookDetailsViewModel(VOLUME_ID, mockModelRepo);

        assertEquals(BOOK_DESCRIPTION, bookDetailsViewModel.description.get());
    }

    @Test
    public void testUpdateBookDetailsViewModel() throws Exception {
        BookDetailsViewModel bookDetailsViewModel = new BookDetailsViewModel(VOLUME_ID, mockModelRepo);
        bookDetailsViewModel.updateBookDetails(BOOK_TITLE, BOOK_AUTHOR, BOOK_YEAR, BOOK_COVER_URL);

        assertEquals(BOOK_TITLE, bookDetailsViewModel.title.get());
        assertEquals(BOOK_AUTHOR, bookDetailsViewModel.author.get());
        assertEquals(BOOK_YEAR, bookDetailsViewModel.year.get());
        assertEquals(BOOK_COVER_URL, bookDetailsViewModel.coverURL.get());

    }

}