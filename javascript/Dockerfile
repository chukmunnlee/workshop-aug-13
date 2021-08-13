FROM node:16

ENV PORT=3000 APP_ROOT=/app

WORKDIR ${APP_ROOT}

ADD main.js .
ADD package.json .
ADD package-lock.json .
ADD public public
ADD views views

RUN npm ci

EXPOSE ${PORT}

HEALTHCHECK --interval=30s --timeout=5s --start-period=5s \
	--retries=3 CMD curl -s -f localhost:3000/healthz || exit 1

ENTRYPOINT [ "node", "main.js" ]

CMD []
