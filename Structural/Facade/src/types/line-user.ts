import { t } from "elysia";

export const registerParams = t.Object({
  uuid: t.String(),
  nickName: t.String(),
  imageUrl: t.String(),
});

export const createLineUserRequestBody = t.Object({
  accessToken: t.Optional(t.String()),
  uuid: t.String(),
  nickName: t.String(),
  imageUrl: t.String(),
});

export type RegisterParams = typeof registerParams.static;
export type CreateLineUserRequest = typeof createLineUserRequestBody.static;
