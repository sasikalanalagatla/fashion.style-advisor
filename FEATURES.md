# Style Advisor Application - Feature Implementation Guide

## Overview

Your Style Advisor application now has a complete flow for selecting and displaying outfits based on climate, person type, and category!

## Features Implemented

### 1. **Home Page** (`/`)

- Select Climate (SUMMER, WINTER, RAINY)
- Select Person Type (CHILD, MALE, FEMALE)
- Click "✨ Get My Outfit ✨" to generate outfit suggestion
- Click "👕 Browse Items" to manually select clothing items
- View "🏆 Popular Outfits" to see community favorites

### 2. **Outfit Suggestion Page** (`/outfit`)

- Displays recommended outfit with:
  - **Topwear** - Click "🛍️ Browse Topwear" to see all topwear for selected climate/person type
  - **Bottomwear** - Click "🛍️ Browse Bottomwear" to see all bottomwear
  - **Accessories** - Click "🛍️ Browse Accessories" to see all accessories
- Like/Dislike buttons to rate outfits
- Refresh button to get new suggestions
- Virtual Try-On section (coming soon)

### 3. **Item Browser Page** (`/browse`)

- Browse clothing items by filters:
  - Climate (SUMMER, WINTER, RAINY)
  - Person Type (CHILD, MALE, FEMALE)
  - Category (TOP, BOTTOM, ACCESSORY)
- Click "✨ Select & Update Outfit" on any item to:
  - Add that item to your outfit
  - Fill in remaining items (top, bottom, accessories) automatically
  - Display the updated outfit on the suggestion page

### 4. **Popular Outfits Page** (`/vote/popular`)

- Shows top 10 most liked outfits
- Vote on outfits (like/dislike)
- See outfit breakdown (topwear, bottomwear, accessories count)

## Data

- **360+ clothing items** in database
- **10 items per category per person type per climate**
  - Summer: Topwear, Bottomwear, Accessories (for Child, Male, Female)
  - Winter: Topwear, Bottomwear, Accessories (for Child, Male, Female)
  - Rainy: Topwear, Bottomwear, Accessories (for Child, Male, Female)
- **Sample outfits** automatically created for each climate/person type combination

## Image Handling

- Images use **placeholder service** (via.placeholder.com) for reliability
- Each item has a colored placeholder with the item category
- Fallback "Image Not Available" message if image fails to load

## How to Run

```bash
# Navigate to project directory
cd /Users/mourya_n/workspace/spring/style-advisor

# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Access at
http://localhost:8080
```

## Database

- **PostgreSQL** database: `advisor`
- **User**: `postgres`
- **Password**: `Sasikala@2361`
- Tables auto-created with JPA Hibernate

## Key Endpoints

| Endpoint             | Method | Purpose                          |
| -------------------- | ------ | -------------------------------- |
| `/`                  | GET    | Home page                        |
| `/suggest`           | POST   | Get outfit suggestion            |
| `/browse`            | GET    | Browse items with filters        |
| `/suggest-with-item` | POST   | Create outfit with selected item |
| `/outfit/{id}`       | GET    | View specific outfit             |
| `/vote/{id}/like`    | POST   | Like an outfit                   |
| `/vote/{id}/dislike` | POST   | Dislike an outfit                |
| `/vote/popular`      | GET    | View popular outfits             |
| `/api/health`        | GET    | Health check (shows item count)  |

## User Flow

```
1. Home Page (/):
   ├─ Option A: Select climate & person type → Get Outfit
   │  └─ Outfit Page (/outfit) with Browse buttons
   │     └─ Browse Items (/browse) → Select Item
   │        └─ Back to Outfit with updated selection
   │
   └─ Option B: Browse Items (/browse)
      └─ Select Item → Outfit Page with auto-filled outfit
```

## Recent Changes

- ✅ Created `/browse` page for browsing items
- ✅ Added item filtering by climate, person type, category
- ✅ Made topwear, bottomwear, accessories clickable in outfit display
- ✅ Added "Browse Items" button on home page
- ✅ Created `/suggest-with-item` endpoint to handle item selection
- ✅ Fixed image loading by using reliable placeholder URLs
- ✅ Added image error handling with fallback messages
- ✅ Database now auto-clears and reinitializes with fresh data on startup

## Next Steps (Optional Enhancements)

- [ ] Add 3D mannequin display using Three.js
- [ ] Add user accounts and save favorite outfits
- [ ] Implement AI-based recommendation system
- [ ] Add real product images from fashion APIs
- [ ] Create mobile app version
- [ ] Add weather-based automatic suggestions
- [ ] Implement outfit sharing on social media
