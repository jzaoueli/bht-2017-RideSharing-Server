package io.oasp.gastronomy.restaurant.general.common.api.constants;

/**
 * Contains constants for the keys of all
 * {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission}s.
 *
 */
public abstract class PermissionConstants {

  // put your permission names from access-control-schema.xml as constants here (or generate with cobigen)
  // BEGIN ARCHETYPE SKIP

  // ** USER **
  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to retrieve staff member. */
  public static final String FIND_CG_MEMBER = "FindCGMember";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to save staff member. */
  public static final String SAVE_CG_MEMBER = "SaveCGMember";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to remove staff member. */
  public static final String DELETE_CG_MEMBER = "DeleteCGMember";

  // ** TRANSPORTPOINT **
  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to retrieve staff member. */
  public static final String FIND_TRANSPORTPOINT = "FindTransportPoint";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to save staff member. */
  public static final String SAVE_TRANSPORTPOINT = "SaveTransportPoint";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to remove staff member. */
  public static final String DELETE_TRANSPORTPOINT = "DeleteTransportPoint";

  // ** REQUEST **
  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to retrieve staff member. */
  public static final String FIND_REQUEST = "FindRequest";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to save staff member. */
  public static final String SAVE_REQUEST = "SaveRequest";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to remove staff member. */
  public static final String DELETE_REQUEST = "DeleteRequest";

  // ** RSOFFER **
  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to retrieve staff member. */
  public static final String FIND_RSOFFER = "FindRSOffer";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to save staff member. */
  public static final String SAVE_RSOFFER = "SaveRSOffer";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to remove staff member. */
  public static final String DELETE_RSOFFER = "DeleteRSOffer";
}
