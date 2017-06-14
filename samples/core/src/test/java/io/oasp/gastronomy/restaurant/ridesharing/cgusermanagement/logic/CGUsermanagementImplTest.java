package io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.CGMemberEntity;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.dataaccess.dao.CGMemberDao;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.api.to.CGMemberEto;
import io.oasp.gastronomy.restaurant.ridesharing.cgusermanagement.logic.impl.CGmanagementImpl;
import io.oasp.gastronomy.restaurant.ridesharing.requestmanagement.logic.impl.RequestmanagementImpl;
import io.oasp.module.beanmapping.common.api.BeanMapper;
import io.oasp.module.test.common.base.ModuleTest;

public class CGUsermanagementImplTest extends ModuleTest {
  /**
   * Initializes mocks before each test method.
   */
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @Mock
  private BeanMapper beanMapper;

  @Mock
  private CGMemberEntity cgMemberEntity;

  @Mock
  private CGMemberEto cgMemberEto;

  @Mock
  private CGMemberDao cgMemberDao;

  @InjectMocks
  CGmanagementImpl cgmanagementImpl = new CGmanagementImpl();

  /**
   * This test method tests the {@code findRequest} method of {@link RequestmanagementImpl} by mocking needed
   * dependencies.
   */
  @Test
  public void testFindCGMember() {

    // given
    long id = 1L;
    Class<CGMemberEto> targetClass = CGMemberEto.class;

    when(this.cgMemberDao.find(id)).thenReturn(this.cgMemberEntity);
    when(this.beanMapper.map(this.cgMemberEntity, targetClass)).thenReturn(this.cgMemberEto);

    // when
    CGMemberEto resultEto = this.cgmanagementImpl.findMember(id);

    // then
    assertThat(resultEto).isNotNull();
    assertThat(resultEto).isEqualTo(this.cgMemberEto);
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

    when(this.cgMemberEto.getId()).thenReturn(id);
    when(this.cgMemberDao.find(id)).thenReturn(this.cgMemberEntity);
    // when(this.requestEto.getName()).thenReturn("new Name");
    // when(this.requestEntity.getName()).thenReturn("old Name");
    when(this.beanMapper.map(this.cgMemberEto, CGMemberEntity.class)).thenReturn(this.cgMemberEntity);
    when(this.cgMemberDao.save(this.cgMemberEntity)).thenReturn(this.cgMemberEntity);
    when(this.beanMapper.map(this.cgMemberEntity, CGMemberEto.class)).thenReturn(this.cgMemberEto);

    // when
    this.cgmanagementImpl.setCGMemberDao(this.cgMemberDao);
    CGMemberEto resultEto = this.cgmanagementImpl.saveMember(this.cgMemberEto);

    // then
    assertThat(resultEto.getId()).isEqualTo(this.cgMemberEto.getId());
  }
}
