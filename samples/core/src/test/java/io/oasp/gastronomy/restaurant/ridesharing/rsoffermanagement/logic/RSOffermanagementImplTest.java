package io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.RSOfferEntity;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.dataaccess.api.dao.RSOfferDao;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.api.to.RSOfferEto;
import io.oasp.gastronomy.restaurant.ridesharing.rsoffermanagement.logic.impl.RSOffermanagementImpl;
import io.oasp.module.beanmapping.common.api.BeanMapper;
import io.oasp.module.test.common.base.ModuleTest;

public class RSOffermanagementImplTest extends ModuleTest {
  /**
   * Initializes mocks before each test method.
   */
  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @Mock
  private BeanMapper beanMapper;

  @Mock
  private RSOfferEntity rsofferEntity;

  @Mock
  private RSOfferEto rsofferEto;

  @Mock
  private RSOfferDao rsofferDao;

  @InjectMocks
  RSOffermanagementImpl rsoffermanagementImpl = new RSOffermanagementImpl();

  /**
   * This test method tests the {@code findRSOffer} method of {@link RSOffermanagementImpl} by mocking needed
   * dependencies.
   */
  @Test
  public void testFindRSOffer() {

    // given
    long id = 1L;
    Class<RSOfferEto> targetClass = RSOfferEto.class;

    when(this.rsofferDao.find(id)).thenReturn(this.rsofferEntity);
    when(this.beanMapper.map(this.rsofferEntity, targetClass)).thenReturn(this.rsofferEto);

    // when
    RSOfferEto resultEto = this.rsoffermanagementImpl.findRSOffer(id);

    // then
    ////assertThat(resultEto).isNotNull();
    ////assertThat(resultEto).isEqualTo(this.rsofferEto);
  }

  /**
   * This test method updates a saved rsofferEntity. It demonstrates the approach when there is a method call in the
   * method under test. To solve this in the given case you need to override the {@code @Inject} of the tested method by
   * using the appropriate setter {@code setRSOfferDao()}.
   */
  @Test
  public void testSaveRSOffer() {

    // given
    long id = 1L;

    when(this.rsofferEto.getId()).thenReturn(id);
    when(this.rsofferDao.find(id)).thenReturn(this.rsofferEntity);
    // when(this.rsofferEto.getName()).thenReturn("new Name");
    // when(this.rsofferEntity.getName()).thenReturn("old Name");
    when(this.beanMapper.map(this.rsofferEto, RSOfferEntity.class)).thenReturn(this.rsofferEntity);
    when(this.rsofferDao.save(this.rsofferEntity)).thenReturn(this.rsofferEntity);
    when(this.beanMapper.map(this.rsofferEntity, RSOfferEto.class)).thenReturn(this.rsofferEto);

    // when
    this.rsoffermanagementImpl.setRSOfferDao(this.rsofferDao);
    RSOfferEto resultEto = this.rsoffermanagementImpl.saveRSOffer(this.rsofferEto);

    // then
    ////assertThat(resultEto.getId()).isEqualTo(this.rsofferEto.getId());
  }
}
