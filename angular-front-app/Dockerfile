# Stage 1: Build the Angular app
FROM node:18-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration production

# Stage 2: Serve with Nginx
FROM nginx:alpine
COPY --from=build /app/dist/angular-front-app /usr/share/nginx/html
# Custom Nginx config to handle Angular routing if needed, but default is often okay if only serving static.
# However, Angular routing requires redirecting 404s to index.html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
