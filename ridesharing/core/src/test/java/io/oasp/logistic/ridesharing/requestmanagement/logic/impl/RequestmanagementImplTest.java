package io.oasp.logistic.ridesharing.requestmanagement.logic.impl;

import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.RequestEntity;
import io.oasp.logistic.ridesharing.requestmanagement.dataaccess.api.dao.RequestDao;
import io.oasp.logistic.ridesharing.requestmanagement.logic.api.to.RequestEto;
import io.oasp.module.beanmapping.common.api.BeanMapper;
import io.oasp.module.test.common.base.ModuleTest;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class RequestmanagementImplTest extends ModuleTest {
    /**
     * Initializes mocks before each test method.
     */
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private BeanMapper beanMapper;

    @Mock
    private RequestEntity requestEntity;

    @Mock
    private RequestEto requestEto;

    @Mock
    private RequestDao requestDao;

    @InjectMocks
    RequestmanagementImpl requestmanagementImpl = new RequestmanagementImpl();

    /**
     * This test method tests the {@code findRequest} method of {@link RequestmanagementImpl} by mocking needed
     * dependencies.
     */
    @Test
    public void testFindRequest() {

        // given
        long id = 1L;
        Class<RequestEto> targetClass = RequestEto.class;

        when(this.requestDao.find(id)).thenReturn(this.requestEntity);
        when(this.beanMapper.map(this.requestEntity, targetClass)).thenReturn(this.requestEto);

        // when
        RequestEto resultEto = this.requestmanagementImpl.findRequest(id);

        // then
        assertThat(resultEto).isNotNull();
        assertThat(resultEto).isEqualTo(this.requestEto);
    }

    /**
     * This test method updates a saved requestEntity. It demonstrates the approach when there is a method call in the
     * method under test. To solve this in the given case you need to override the {@code @Inject} of the tested method by
     * using the appropriate setter {@code setRequestDao()}.
     */
    @Test
    public void testSaveRequest() {

        // given
        long id = 1L;

        when(this.requestEto.getId()).thenReturn(id);
        when(this.requestDao.find(id)).thenReturn(this.requestEntity);
//        when(this.requestEto.getName()).thenReturn("new Name");
//        when(this.requestEntity.getName()).thenReturn("old Name");
        when(this.beanMapper.map(this.requestEto, RequestEntity.class)).thenReturn(this.requestEntity);
        when(this.requestDao.save(this.requestEntity)).thenReturn(this.requestEntity);
        when(this.beanMapper.map(this.requestEntity, RequestEto.class)).thenReturn(this.requestEto);

        // when
        this.requestmanagementImpl.setRequestDao(this.requestDao);
        RequestEto resultEto = this.requestmanagementImpl.saveRequest(this.requestEto);

        // then
        assertThat(resultEto.getId()).isEqualTo(this.requestEto.getId());
    }
}
